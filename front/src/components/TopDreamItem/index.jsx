import React from "react";
import style from "./styled.module.css";

const TopDreamItem = ({
      id,
      title,
      place,
      hashTag,
      deadline,
      createDate,
}) => {

    console.log(" id : " + id + " title : " + title + " place : " +  place
        + " hashTag : " + hashTag + " deadline : " + deadline + " createDate : " + createDate);

    return (
        <div className={style.box}>
            <div className={style.view}>
                <div className={style.element}>
                    <div className={style.overlap_group}>
                        <div className={style.text_wrapper}>{ hashTag }</div>
                    </div>
                </div>
                <p className={style.p}>{ title }</p>
                <img className={style.chick} alt="Chick" src="chick-1.png" />
                <div className={style.group}>
                    <div className={style.text_wrapper_2}>{ place }</div>
                    <img className={style.vector} alt="Vector" src="vector.svg" />
                </div>
                <div className={style.group_wrapper}>
                    <div className={style.div_wrapper}>
                        <div className={style.text_wrapper_3}>{ deadline }</div>
                    </div>
                </div>
                <div className={style.element_2}>{ place }</div>
                <div className={style.group_2} />
                <div className={style.overlap_group_wrapper}>
                    <div className={style.overlap}>
                        <div className={style.text_wrapper_4}>신청하기</div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default TopDreamItem;