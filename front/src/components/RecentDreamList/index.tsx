import style from "./styled.module.css";
import RecentDreamItem from "../RecentDreamItem/index.tsx";
import {DreamItemType} from "@myTypes/dream/internal.ts";


type RecentDreamListProps = {
    dreams: DreamItemType[];
}

const RecentDreamList = ({ dreams } : RecentDreamListProps) => {
    return (
        <div className={style.dream_list_form}>
            {dreams.length > 0 ? (
                dreams
                    .filter((dream) => dream) // undefined나 null 값 제거
                    .map((dream) => (
                    <RecentDreamItem
                        dream={dream}
                        key={dream.dreamId || ''}
                        {...dream} />
                ))
            ): (
                <p>No dreams available.</p>
            )}
        </div>
    );
};

export default RecentDreamList;