import React from "react";
import style from "./styled.module.css";

const KakaoLogin = () => {
    return (
        <div>
            <div className={style.kakao_login}>
                <div className={`${style.kakao_icon}`}></div>
                <div className={style.kakao_text}>카카오 로그인</div>
            </div>
        </div>
    );
};

export default KakaoLogin;