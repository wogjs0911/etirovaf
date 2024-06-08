import { defaultMemberInfo } from '@components/_providers/MemberInfoProvider';

export type MemberInfoContextType = {
  memberInfo: typeof defaultMemberInfo;
  setMemberInfo: React.Dispatch<React.SetStateAction<typeof defaultMemberInfo>>;
};
