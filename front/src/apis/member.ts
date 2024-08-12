import client from '@apis/axios/client';
import {
    MemberJoinRequest,
    OAuthResponse,
    MemberLoginRequest,
    MemberLoginResponse,
    MemberInfoResponse
} from '@myTypes/member/remote';

export const signUp = (body: MemberJoinRequest) => {
    return client.post('/member/add', body);
};

export const naverLogin = async () => {
    const { data } = await client.get<OAuthResponse>('/auth/oauth/naver');

    return data;
};

export const login = (body: MemberLoginRequest) => {
    return client.post<MemberLoginResponse>('/auth/login', body);
};

export const getMemberInfo = (signal?: AbortSignal) => {
    return client.get<MemberInfoResponse>('/member', {
        signal,
    });
};
