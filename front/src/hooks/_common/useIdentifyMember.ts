import { getMemberInfo } from '@/apis/member';
import { MemberInfoResponse } from '@myTypes/member/remote';
import { getCookie } from '@/utils/_common/cookies';
import { useEffect, useState } from 'react';

export const defaultUserInfo: MemberInfoResponse = {
  id: null,
  nickname: '',
  profileImageUrl: '',
  identifier: '',
  phoneNumber: '',
};

export const useIdentifyMember = () => {
  const [memberInfo, setMemberInfo] = useState(defaultUserInfo);

  useEffect(() => {
    const fetchController = new AbortController();
    const { signal } = fetchController;

    const fetchMemberInfo = async () => {
      try {
        const accessToken = getCookie('access_token');

        if (!accessToken) return;

        const memberInfo = (await getMemberInfo(signal)).data;

        setMemberInfo(memberInfo);
      } catch (e) {
        // 실패시 로직
      }
    };

    fetchMemberInfo();

    return () => fetchController.abort();
  }, []);

  return {
    memberInfo,
    setMemberInfo,
  };
};
