/* eslint-disable */

import style from "./styled.module.css";
import NoticeItem from "../NoticeItem/index.tsx";
import {DreamItemType} from "@myTypes/dream/internal.tsx";


type NoticeListProps = {
    dreams: DreamItemType[];
}


const NoticeList = ({ dreams } : NoticeListProps) => {
    return (
        <div className={style.dream_list_form}>
            {dreams.map((dream) => (
                <NoticeItem
                    dream={dream}
                    key={dream.id}
                    {...dream} />
            )) }
        </div>
    );
};

export default NoticeList;