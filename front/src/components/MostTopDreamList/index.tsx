import style from "./styled.module.css";
import MostTopDreamItem from "../MostTopDreamItem/index.tsx";
import {DreamItemType} from "@myTypes/dream/internal.ts";

type MostTopDreamItemProps = {
    dreams: DreamItemType[];
}

const MostTopDreamList = ({ dreams } : MostTopDreamItemProps) => {
    return (
        <div className={style.dream_list_form}>
            {dreams.length > 0 ? (
                dreams
                    .filter((dream) => dream) // undefined나 null 값 제거
                    .map((dream) => (
                    <MostTopDreamItem
                        dream={dream}
                        key={dream.id || ''}
                        {...dream} />
                ))
            ): (
                <p>No dreams available.</p>
            )}
        </div>
    );
};

export default MostTopDreamList;