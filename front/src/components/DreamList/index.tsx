import style from "./styled.module.css";
import DreamItem from "../DreamItem/index.tsx";
import {DreamItemType} from "@myTypes/dream/internal.ts";

type DreamListProps = {
    dreams: DreamItemType[];
}

const DreamList = ({ dreams } : DreamListProps) => {
    return (
        <div className={style.dream_list_form}>
            {dreams.length > 0 ? (
                dreams
                    .filter((dream) => dream) // undefined나 null 값 제거
                    .map((dream) => (
                    <DreamItem
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

export default DreamList;