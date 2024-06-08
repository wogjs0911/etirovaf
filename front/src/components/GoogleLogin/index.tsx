import style from "./styled.module.css";

const GoogleLogin = () => {
    return (
        <div>
            {/*<GoogleLogin callback={customLoginHandler} popup-type="TOKEN">*/}
                <div className={style.google_login}>
                    <div className={style.google_icon}></div>
                    <div className={style.text}>Google 계정 로그인</div>
                </div>
            {/*</GoogleLogin>*/}
        </div>
    );
};

export default GoogleLogin;