import { MemberInfoResponse } from '@myTypes/member/remote';

const isValidMemberInfo = (memberInfo: MemberInfoResponse): boolean => {
  return Object.values(memberInfo).every((value) => Boolean(value));
};

export default isValidMemberInfo;
