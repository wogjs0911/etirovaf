import style from "./styled.module.css";
import {useNavigate} from "react-router-dom";
import Bookmark from "../Bookmark/index.tsx";
import {DreamItemType} from "@myTypes/dream/internal.ts";

type RecentDreamListProps = {
    dream: DreamItemType;
}


const RecentDreamItem = ({ dream } : RecentDreamListProps) => {
    const nav = useNavigate();

    const onClickItem = () => {
        nav(`/dream/${dream.id}`, {state: {'id': dream.id}});
    }

    return (
        <div onClick={ onClickItem } className={style.list_wrap}>
            <div className={style.dream_list}>
                <div className={style.list_grid}>
                    <div className={style.top_list_pic}>
                        {/*<img className={style.listview_image} src={"../../"} alt="img"/>*/}
                        <div className={style.listview_image}></div>
                    </div>
                    <div className={style.list_heart}>
                        <Bookmark />
                    </div>
                    <div className={style.list_title}>{ dream.title }</div>
                    <div className={style.list_organ_form}>
                        <span className={style.list_organ}>
                                { dream.organizer }
                        </span>
                    </div>
                    <div className={style.list_place_form}>
                        <span className={style.list_place}>
                                { dream.place }
                        </span>
                    </div>
                    <div className={ style.content_form }>{ dream.content }</div>
                    <div className={`${style.list_dday} ${style.day_left}`}>{ dream.deadline }</div>
                    <div className={style.list_hashtag_form}>
                        <span className={style.list_hashtag}>
                            { dream.hashTag }
                        </span>
                    </div>
                    <div className={style.list_btn_form}>
                        <button className={style.list_btn}>신청하기</button>
                    </div>
                </div>
            </div>
        </div>
    )
};

export default RecentDreamItem;