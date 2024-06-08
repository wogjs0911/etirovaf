import style from "./styled.module.css";
import TopDreamItem from "../TopDreamItem/index";
import { DreamItemType } from "@myTypes/dream/internal.ts";

type TopDreamListProps = {
    dreams: DreamItemType[];
}

const TopDreamList = ({ dreams } : TopDreamListProps) => {
    return (
        <div className={style.dream_list_form}>
            {dreams.map((dream) => (
                <TopDreamItem
                    dream={dream}
                    key={dream.id}
                    {...dream}
                />
            ))}
        </div>
    );
};

export default TopDreamList;


// import React from "react";
// import style from "./styled.module.css";
// import TopDreamItem from "../TopDreamItem/index.tsx";
//
// const TopDreamList = ({ dreams }) => {
//     return (
//         <div className={style.dream_list_form}>
//             {dreams.map((dream) => (
//                 <TopDreamItem
//                     className={style.dream_list}
//                     dream={dream}
//                     key={dream.id}
//                     {...dream} />
//             )) }
//         </div>
//     );
// };
//
// export default TopDreamList;