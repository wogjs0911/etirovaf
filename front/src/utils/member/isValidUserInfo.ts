import { MemberInfoResponse } from '@myTypes/member/remote';

const isValidUserInfo = (userInfo: MemberInfoResponse): boolean => {
  return Object.values(userInfo).every((value) => Boolean(value));
};

export default isValidUserInfo;
