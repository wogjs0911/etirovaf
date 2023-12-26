import style from "./styled.module.css";
import { useState, useEffect } from "react";
import globalStyle from "../../styles/style.module.css";
import utilStyle from "../../styles/utils.module.css";
import btnStyle from "../../styles/button.module.css";
import { Link } from "react-router-dom";


const Signup = () => {

    return (
        <div className={style.wrap}>
            <header className={`${utilStyle.d_fl_ac} ${style.al_cen} ${style.header}`}>
                <Link to={"/login"} className={`${globalStyle.icon} ${globalStyle.icon_back}`}>Back</Link>
                <div className={style.signup_title}>
                    회원가입
                </div>
            </header>
            {/*<!-- ----------------------------------------------------------- -->*/}
            <main className={style.m_t_31}>
                {/* flex 시작 */}
                <div className={style.sign_up_container}>
                    <form id="signup-vue" action="signup" method="post">
                        <div className={style.input_field_2}>
                            <div className={style.input_info_label}>
                                <label htmlFor="uid">
                                    <span className={style.input_info_title}>아이디</span>
                                </label>
                            </div>
                            <div className={style.input_info_form}>
                                <input type="text" id="uid" name="uid" className={style.input_text_2}
                                   placeholder="아이디를 입력해주세요." />
                                {/*<div className={btnStyle.btn_null}></div>*/}
                                {/*<div className={btnStyle.btn_check}></div>*/}
                                {/*<div className={btnStyle.btn_x}></div>*/}
                            </div>
                            {/*<div className={style.error_font}>{ uidError }</div>*/}
                        </div>
                        <div className={style.input_field_2}>
                            <div className={style.input_info_label}>
                                <label htmlFor="password">
                                    <span className={style.input_info_title}>비밀번호</span>
                                </label>
                            </div>
                            <div className={style.input_info_form}>
                                <input type="password" id="pwd" name="pwd" className={style.input_text_2}
                                       placeholder="비밀번호를 입력해주세요." />
                                {/*<div className={btnStyle.btn_null}></div>*/}
                                {/*<div className={btnStyle.btn_check}></div>*/}
                                {/*<div className={btnStyle.btn_x}></div>*/}
                            </div>
                            {/*<div className={style.error_font}>{ this.pwdError }</div>*/}
                        </div>
                        <div className={style.input_field_2}>
                            <div className={style.input_info_label}>
                                <label htmlFor="password-confirm">
                                    <span className={style.input_info_title}>비밀번호 확인</span>
                                </label>
                            </div>
                            <div className={style.input_info_form}>
                                <input type="password" id="password-confirm" name="repassword" className={style.input_text_2}
                                   placeholder="비밀번호를 다시 입력해주세요." />
                                {/*<div className={btnStyle.btn_null}></div>*/}
                                {/*<div className={btnStyle.btn_check}></div>*/}
                                {/*<div className={btnStyle.btn_x}></div>*/}
                            </div>
                            {/*<div className={style.error_font}>{ nameError }</div>*/}
                        </div>

                        <div className={style.input_field_2}>
                            <div className={style.input_info_label}>
                                <label htmlFor="nickname">
                                    <span className={style.input_info_title}>닉네임</span>
                                </label>
                            </div>
                            <div className={style.input_info_form}>
                                <input type="text" id="nickname" name="nickname" className={style.input_text_2}
                                       placeholder="닉네임을 입력해주세요." />
                                {/*<div className={btnStyle.btn_null}></div>*/}
                                {/*<div className={btnStyle.btn_check}></div>*/}
                                {/*<div className={btnStyle.btn_x}></div>*/}
                            </div>
                            {/*<div className={style.error_font}>{ nicknameError }</div>*/}
                        </div>

                        <div className={style.input_field_2}>
                            <div className={style.input_info_label}>
                                <label htmlFor="phoneNumber">
                                    <span className={style.input_info_title}>휴대전화번호</span>
                                </label>
                            </div>
                            <div className={style.input_info_form}>
                                <input type="text" id="phoneNumber" name="phoneNumber" className={style.input_text_2} placeholder="휴대전화번호를 입력해주세요."
                               />
                                <input className={style.btn_post} id="btn-post" type="button" value="인증요청" />
                                {/*<div className={btnStyle.btn_null}></div>*/}
                                {/*<div className={btnStyle.btn_check}></div>*/}
                                {/*<div className={btnStyle.btn_x}></div>*/}
                            </div>
                            {/*<div className={style.error_font}>{ phoneNumberError }</div>*/}
                            {/*<div className={style.error_font}>{ phoneNumberCheckError }</div>*/}
                        </div>

                        <div className={style.input_field_2}>
                            <div className={style.input_info_label}>
                                <label htmlFor="phoneNumberConfirm">
                                    <span className={style.input_info_title}>인증번호</span>
                                </label>
                            </div>
                            <div className={style.input_info_form}>
                                <input type="text" id="phoneNumberConfirm" name="phoneNumberConfirm" className={style.input_text_2} placeholder="인증번호를 입력해주세요."
                                       />
                                <input className={style.btn_post} id="btn-post" type="button" value="인증" />
                                {/*<div className={btnStyle.btn_check}></div>*/}
                            </div>
                            {/*<div className={style.error_font}>{ phoneCodeError } </div>*/}
                        </div>

                        <div className={`${utilStyle.d_fl_jf} ${utilStyle.m_t_28}`}>
                            <input className={style.btn_signup} type="submit" value="가입하기" />
                        </div>
                    </form>

                    {/* 에러메시지 모달창 */}
                    {/*<div className={style.black_bg}>*/}
                    {/*    <div className={style.error_box}>{ ErrorMsg }*/}
                    {/*       <div className={style.error_close}></div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}

                    {/*<div className={style.black_bg}>*/}
                    {/*    <div className={style.findpwd_modal_box}>*/}
                    {/*        <div className={style.modal_txt}>가입 완료되었습니다!</div>*/}
                    {/*        <button className={style.modal_btn}>확인</button>*/}
                    {/*    </div>*/}
                    {/*</div>*/}
                </div>
                {/* flex 끝 */}
            </main>
        </div>
    );
}

export default Signup;