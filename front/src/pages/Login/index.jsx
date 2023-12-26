import style from "./styled.module.css";
import globalStyle from "../../styles/style.module.css";
import utilStyle from "../../styles/utils.module.css";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";

const Login = () => {

    // const customLoginHandler = () => {
    //     await fetch(`https://www.googleapis.com/oauth2/v3/userinfo?access_token=${response.access_token}`)
    //         .then(res => res.json())
    //         .then(credential => {
    //             this.userDetails.email = credential.email
    //         })
    //         .catch(e => {
    //             console.log("error");
    //         });
    //     this.checkEmail();
    // }

    return (
        <div className={`${globalStyle.canvas} ${style.f_family}`}>

            <header>
                <div className={style.header_container}>
                    <h1 className={`${globalStyle.logo_main} ${style.logo_etirovaf} ${style.logo_size1} ${utilStyle.m_t_80}`}>etirovaf</h1>
                </div>
            </header>

            <main>
                <div className={style.input_container}>

                    <form>

                        <div className={style.input_field_1}>
                            <div className={style.input_info_label}>
                                <label htmlFor="uid">
                                    <span className={style.input_info_title}>아이디</span>
                                </label>
                            </div>
                            <div className={style.input_info_form}>
                                <input type="text" className={style.input_text}
                                       placeholder="아이디를 입력해주세요." autoFocus />
                            </div>
                        </div>
                        <div className={`${style.input_field_1} ${utilStyle.m_t_20}`}>
                            <div className={style.input_info_label}>
                                <label htmlFor="password">
                                    <span className={style.input_info_title}>비밀번호</span>
                                </label>
                            </div>
                            <div className={style.input_info_form}>
                                <input type="password" className={style.input_text}
                                       placeholder="비밀번호를 입력해주세요." />
                            </div>
                        </div>
                        <div className={style.find_box}>
                            <div className={style.find_box_2}>
                                <Link to={"/login/findid"}>
                                    <span className={style.find_text}>아이디 찾기</span>
                                </Link>
                                <span className={style.find_text2}>|</span>
                                <Link to={"/login/findpwd"}>
                                    <span className={style.find_text}>비밀번호 찾기</span>
                                </Link>
                            </div>
                        </div>
                        {/*<div className={style.error}>{ errormsg }</div>*/}
                        <div className={style.login_btn_form}>
                            <Link to={"/home"}>
                                <input className={style.btn_login} type="submit" value="로그인" />
                            </Link>
                        </div>
                        <div>
                            <Link to={"/signup"} className={style.signup_text}>
                                <input className={style.btn_signup} type="submit" value="회원가입" />
                            </Link>
                        </div>
                    </form>
                </div>
                {/* 아이디찾기 ~ 플렉스 */}
                <div className={style.find_container}>
                    <div className={utilStyle.d_fl_ac}>
                        <hr />
                        <span className={style.text}>&nbsp;또는&nbsp;</span>
                        <hr />
                    </div>

                    {/*<GoogleLogin callback={customLoginHandler} popup-type="TOKEN">*/}
                        <div className={style.google_login}>
                            <div className={style.google_icon}></div>
                            <div className={style.text}>Google 계정 로그인</div>
                        </div>
                    {/*</GoogleLogin>*/}

                    <div className={style.kakao_login}>
                        {/*<div className={`${globalStyle.icon} ${style.kakao_icon}`}></div>*/}
                        <div className={`${style.kakao_icon}`}></div>
                        <div className={style.kakao_text}>카카오 로그인</div>
                    </div>
                </div>
            </main>
        </div>
    );
}

export default Login;