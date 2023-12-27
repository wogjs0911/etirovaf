import React from "react";
import style from "./styled.module.css";

const ErrorModal = () => {
    return (
        // 에러메시지 모달창
        <div className={style.black_bg}>
            <div className={style.error_box}>다시 확인해주세요.
               <div className={style.error_close}></div>
            </div>
        </div>
    );
};

export default ErrorModal;