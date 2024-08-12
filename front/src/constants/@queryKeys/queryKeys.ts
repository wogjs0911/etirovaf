const QUERY_KEYS = {
  member: {
    member: 'member',
    naver_oauth: 'naver_login',
  },
  dream: {
    list: 'dreamList',
    detail: 'dreamDetail'
  }
} as const;

export default QUERY_KEYS;
