import style from "./styled.module.css";
import RecentDreamItem from "../RecentDreamItem/index.tsx";
import {DreamItemType} from "@myTypes/dream/internal.tsx";


type RecentDreamListProps = {
    dreams: DreamItemType[];
}

const RecentDreamList = ({ dreams } : RecentDreamListProps) => {
    return (
        <div className={style.dream_list_form}>
            {dreams.map((dream) => (
                <RecentDreamItem
                    dream={dream}
                    key={dream.id}
                    {...dream} />
            )) }
        </div>
    );
};

export default RecentDreamList;