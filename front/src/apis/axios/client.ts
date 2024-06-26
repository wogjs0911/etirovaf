import axios, { AxiosError } from 'axios';
import { getCookie } from '@utils/_common/cookies';

export type ErrorResponse = {
  message: string;
};

export const BASE_URL = `${
    import.meta.env.DEV_SERVER === 'true' ? import.meta.env.DEV_SERVER : import.meta.env.PROD_SERVER
}`;

let ACCESS_TOKEN = localStorage.getItem("accessToken");

const client = axios.create({
  baseURL: 'http://localhost:8080',
  headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${ACCESS_TOKEN}`,
  },
});

client.interceptors.request.use((config) => {
  const token = getCookie('access_token');

  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }

  return config;
});

client.interceptors.response.use(
  (response) => response,
  async (error) => {
    const originalRequest = error.config;

    if (error.response) {
      if (error.response.status === 401 && error.response.data.message === 'Token') {
        if (!originalRequest.shouldRetry) {
          originalRequest.shouldRetry = true;
          const refreshToken = getCookie('refresh_token');
          try {
            // refresh token으로 새로운 access token을 발급받는 API를 호출합니다.
            const { data } = await client.post('/api/auth/reissue', { refreshToken });
            // 새로 받은 access token으로 기본 header를 설정합니다.
            client.defaults.headers.common.Authorization = `Bearer ${data.access_token}`;
            // 원래의 요청에도 새로운 access token을 설정합니다.
            originalRequest.headers.Authorization = `Bearer ${data.access_token}`;
``
            // 원래의 요청을 재시도합니다.
            return client(originalRequest);
          } catch (reissueError) {
            // refresh token으로도 실패하면 로그인 페이지로 리다이렉트합니다.
            const axiosError = reissueError as AxiosError;

            if (
              axiosError.response?.status === 401 &&
              (axiosError.response.data as ErrorResponse).message === 'Expired Token'
            ) {
              window.location.href = '/login';
            }
          }
        }
      } else {
        throw new Error(error.response.data.message);
      }
    }

    throw error;
  }
);

export default client;
