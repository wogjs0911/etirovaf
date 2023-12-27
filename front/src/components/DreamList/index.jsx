import React from "react";
import style from "./styled.module.css";
import DreamItem from "../DreamItem/index.jsx";

const DreamList = ({ dreams }) => {
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