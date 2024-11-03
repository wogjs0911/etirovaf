import {useSearchParams} from "react-router-dom"
import style from "./styled.module.css";
import Searchbar from "@components/Searchbar";
import Notification from "@components/Notification";
import Category from "@components/Category/index";
import MostTopDreamList from "@components/MostTopDreamList";
import {useDreamList} from "@hooks/queries/dream.ts";
import {useInfiniteScroll} from "@hooks/_common/useInfiniteScroll.ts";
import Index from "@components/_common/wavyLoading";

const DreamSearch = () => {
    const [ searchParams ] = useSearchParams();
    const q = searchParams.get("q") || "";
    // useEffect (() => {
    //     setInitData();
    // }, [q]);

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
                <div className={style.searchBox}>
                    <Searchbar q={q || ''}/>
                </div>
                <Notification />
            </div>
            <div className={style.category}>
                <Category />
            </div>
            <div>
                <b>{q}</b> 검색 결과
            </div>
            <div className={style.top_list_form}>
                <div className={style.top_list_explain}>
                    <div>
                        가장 인기있는 목록
                    </div>
                </div>
                <div className={style.top_list}>
                    <MostTopDreamList dreams={dreamList}/>
                    {hasNext && <Index loadMoreRef={loadMoreRef} />}
                </div>
            </div>
        </div>

    );
}

export default DreamSearch;