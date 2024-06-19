export type MemberJoinRequest = {
  identifier: string;
  password: string;
  nickname: string;
  phoneNumber: string;
};

export type MemberLoginRequest = {
  identifier: string;
  password: string;
};

export type OAuthResponse = {
  accessToken: string;
  refreshToken: string;
};

export type MemberLoginResponse = {
  data : {
    accessToken: string;
    refreshToken: string;
  }
};

export type MemberInfoResponse = {
  data : {
    id: number | null;
    nickname: string;
    profileImageUrl: string;
    identifier: string;
    phoneNumber: string;
  }
};
