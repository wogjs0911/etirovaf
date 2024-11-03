/* eslint-disable */

import style from "./styled.module.css";
import utilStyle from "@styles/utils.module.css";
import Searchbar from "@components/Searchbar";
import Notification from "@components/Notification";
import Category from "@components/Category";
import TopDreamList from "@components/TopDreamList";
import RecentDreamList from "@components/RecentDreamList";
import {Link, useNavigate } from "react-router-dom";
import {useMemberInfoContext} from "@components/_providers/MemberInfoProvider.tsx";
import {useLogout} from "@hooks/queries/member.ts";
import {useInfiniteScroll} from "@hooks/_common/useInfiniteScroll.ts";
import {useDreamList} from "@hooks/queries/dream.ts";
import Index from "@components/_common/wavyLoading";

const Home = () => {
    const { memberInfo } = useMemberInfoContext();
    const nav = useNavigate();

    const { logout } = useLogout();

    const handleLogout = () => {
        logout();
        nav('/home');
    }

    // const { id } = useValidParams<{ id: string }>();
    // const [sortedOption, setSortedOption] = useState<
    //     (typeof dreamFilter)[keyof typeof dreamFilter]
    // >(dreamFilter['1']);
    const {
        dreamListResponse: { responses: dreamList, hasNext },
        fetchNextPage,
    } = useDreamList({
        // id: Number(id),
        // filterCond:
        //     sortedOption === dreamFilter['1'] ? FILTER_COND.latest : FILTER_COND.deadline,
    });

    const loadMoreRef = useInfiniteScroll({
        hasNextPage: hasNext,
        fetchNextPage,
    });

    return (
        <div className={style.container}>
            <div className={style.header}>
                { memberInfo.data.identifier ? (
                    <div className={style.login_btn_form}>
                        <input className={style.btn_login} type="submit"
                               onClick={handleLogout} value="로그아웃" />
                    </div>
                ) : (
                    <Link to="/login" className={style.login_btn_form}>
                        <input className={style.btn_login} type="submit" value="로그인" />
                    </Link>
                )}

                <div className={utilStyle.d_fl_jf}>
                    <div className={style.searchBox}>
                        <Searchbar q={''}/>
                    </div>
                    <Notification />
                </div>
            </div>
            <div className={style.category}>
                <Category />
            </div>
            <div className={style.top_list_form}>
                <div className={style.top_list_explain}>
                    <div>가장 인기있는 목록</div>
                    <div className={style.f_blue}>자세히 보기</div>
                </div>
                <div className={style.top_list}>
                    <TopDreamList dreams={dreamList} />
                </div>
            </div>
            <div className={style.top_list_form}>
                <div className={style.top_list_explain}>
                    <div>최근 업로드된 목록</div>
                    <div className={style.f_blue}>자세히 보기</div>
                </div>
                <div className={style.recent_list}>
                    <RecentDreamList dreams={dreamList} />
                    {hasNext && <Index loadMoreRef={loadMoreRef} />}
                </div>
            </div>
        </div>
    );
};

export default Home;