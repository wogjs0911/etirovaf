import style from "./styled.module.css";
import DreamItem from "../DreamItem/index.tsx";
import {DreamItemType} from "@myTypes/dream/internal.tsx";

type DreamListProps = {
    dreams: DreamItemType[];
}

const DreamList = ({ dreams } : DreamListProps) => {
    return (
        <div className={style.dream_list_form}>
            {dreams.map((dream) => (
                <DreamItem
                    dream={dream}
                    key={dream.id}
                    {...dream} />
            )) }
        </div>
    );
};

export default DreamList;