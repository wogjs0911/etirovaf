import style from "./styled.module.css";
// import { useNavigate } from "react-router-dom";

// const setModalOpen = false;

type NoticeSettingModalProps = {
    setModalOpen: (isOpen: boolean) => void;
}

const NoticeSettingModal = ( { setModalOpen } : NoticeSettingModalProps) => {
    // const nav = useNavigate();


    const onClickCloseNotice = () =>{
        setModalOpen(false);
    }

    return (
        <div className={style.wrap}>
            <div className={style.black_bg}>
                <div className={style.notice_modal_box}>
                    <div className={style.modal_txt_form}>
                        <input className={style.modal_txt} placeholder="키워드 입력">

                        </input>
                        <button className={style.modal_reg_btn}>등록</button>
                    </div>
                    <div className= { style.notice_list }>
                        <div>
                            <button className={ style.notice_item }>
                                <div className={ style.delete_keyword_notice }>
                                    디자이너
                                </div>
                            </button>
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