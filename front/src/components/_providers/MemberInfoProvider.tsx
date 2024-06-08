import { createContext, PropsWithChildren, useContext } from 'react';
import { MemberInfoResponse } from '@myTypes/member/remote';
import { MemberInfoContextType } from '@myTypes/_common/member';
import { useIdentifyMember } from '@hooks/_common/useIdentifyMember';

export const defaultMemberInfo: MemberInfoResponse = {
  id: null,
  nickname: '',
  profileImageUrl: '',
  identifier: '',
  phoneNumber: '',
};

export const memberInfoContext = createContext<MemberInfoContextType>({
  memberInfo: defaultMemberInfo,
  setMemberInfo: () => {},
});

const MemberInfoProvider = ({ children }: PropsWithChildren) => {
  const { memberInfo, setMemberInfo } = useIdentifyMember();

  return (
    <memberInfoContext.Provider value={{ memberInfo, setMemberInfo }}>
      {children}
    </memberInfoContext.Provider>
  );
};

export const useMemberInfoContext = () => useContext(memberInfoContext);

export default MemberInfoProvider;
