import React from "react";
import style from "./styled.module.css";
import TopDreamItem from "../TopDreamItem/index.jsx";

const TopDreamList = ({ dreams }) => {

    console.log(dreams);

    return (
        <div className={style.box}>
            {dreams.map((dream) => (
                <TopDreamItem
                    dream={dream}
                    key={dream.id}
                    {...dream} />
            )) }
        </div>
    );
};

export default TopDreamList;