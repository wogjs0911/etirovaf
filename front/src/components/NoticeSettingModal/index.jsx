import style from "./styled.module.css";
import globalStyle from "../../styles/style.module.css";
import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

const NoticeSettingModal = ( { setModalOpen } ) => {
    const nav = useNavigate();

    const onClickCloseNotice = () =>{
        setModalOpen(false);
    }

    return (
        <div className={style.wrap}>
            <div className={style.black_bg}>
                <div className={style.notice_modal_box}>
                    <div className={style.modal_txt_form}>
                        <div className={style.modal_txt}>
                            키워드 입력
                        </div>
                        <button className={style.modal_reg_btn}>등록</button>
                    </div>
                    <div className= { style.notice_list }>
                        <div>
                            <button className={ style.notice_item }>디자이너</button>
                        </div>
                        <div>
                            <button className={ style.notice_item }>개발자</button>
                        </div>
                        <div>
                            <button className={ style.notice_item }>기획자</button>
                        </div>
                        <div>
                            <button className={ style.notice_item }>디자이너</button>
                        </div>
                        <div>
                            <button className={ style.notice_item }>개발자</button>
                        </div>
                        <div>
                            <button className={ style.notice_item }>기획자</button>
                        </div>
                    </div>
                    <div className={style.modal_btn_form}>
                        <button className={style.modal_cancel_btn} onClick={onClickCloseNotice}>취소</button>
                        <button className={style.modal_set_btn}>적용</button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default NoticeSettingModal;