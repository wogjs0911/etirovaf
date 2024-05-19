import { useMutation } from '@tanstack/react-query';
import {
  MemberJoinRequest,
  MemberInfoResponse,
  MemberLoginRequest,
} from '@myTypes/member/remote';
import { getMemberInfo, login, naverLogin, signUp } from '@apis/member';
// import useToast from '@hooks/_common/useToast';
import {
  defaultMemberInfo,
  useMemberInfoContext
} from '@components/_providers/MemberInfoProvider.tsx';
import { AxiosResponse } from 'axios';
import { useNavigate } from 'react-router-dom';
import { setCookie } from '@/utils/_common/cookies';
import logout from '@utils/member/logout';
import { useSuspendedQuery } from './useSuspendedQuery';
import QUERY_KEYS from '@/constants/@queryKeys/queryKeys';

export const useSignUp = () => {
  // const { triggerToast } = useToast();
  const navigate = useNavigate();

  const { mutate } = useMutation(
    (memberJoinPayload: MemberJoinRequest) => signUp(memberJoinPayload),
    {
      onSuccess() {
        // triggerToast({ message: '회원가입 성공!' });
        navigate('/login');
      },
    }
  );

  return {
    signUp: mutate,
  };
};

export const useNaverLogin = async () => {
  const navigate = useNavigate();
  // const { triggerToast } = useToast();
  const { setMemberInfo } = useMemberInfoContext();

  useSuspendedQuery([QUERY_KEYS.member.naver_oauth], () => naverLogin(), {
    onSuccess({ accessToken, refreshToken }) {
      setCookie('access_token', accessToken);
      setCookie('refresh_token', refreshToken);
      // triggerToast({ message: '로그인 성공!' });

      getMemberInfo().then((response: AxiosResponse<MemberInfoResponse>) => {
        setMemberInfo(response.data);
      });

      navigate('/home');
    },
  });
};

export const useLogin = () => {
  const navigate = useNavigate();
  // const { triggerToast } = useToast();
  const { setMemberInfo } = useMemberInfoContext();

  const { mutate } = useMutation(
    (loginPayload: MemberLoginRequest) => login(loginPayload),
    {
      onSuccess(response) {
        const { accessToken, refreshToken } = response.data;
        setCookie('access_token', accessToken);
        setCookie('refresh_token', refreshToken);
        // triggerToast({ message: '로그인 성공!' });

        getMemberInfo().then((response: AxiosResponse<MemberInfoResponse>) => {
          setMemberInfo(response.data);
        });

        navigate('/home');
      },
    }
  );

  return {
    login: mutate,
  };
};

export const useLogout = () => {
  // const { triggerToast } = useToast();
  const { setMemberInfo } = useMemberInfoContext();

  const triggerLogout = () => {
    logout();
    setMemberInfo(defaultMemberInfo);
    // triggerToast({ message: '로그아웃 성공!' });
  };

  return { logout: triggerLogout };
};
