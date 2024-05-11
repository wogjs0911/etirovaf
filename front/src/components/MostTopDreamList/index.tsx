import style from "./styled.module.css";
import MostTopDreamItem from "../MostTopDreamItem/index.tsx";
import {DreamItemType} from "@myTypes/dream/internal.tsx";

type MostTopDreamItemProps = {
    dreams: DreamItemType[];
}

const MostTopDreamList = ({ dreams } : MostTopDreamItemProps) => {
    return (
        <div className={style.dream_list_form}>
            {dreams.map((dream) => (
                <MostTopDreamItem
                    dream={dream}
                    key={dream.id}
                    {...dream} />
            )) }
        </div>
    );
};

export default MostTopDreamList;