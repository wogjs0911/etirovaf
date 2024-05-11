import style from "./styled.module.css";
import globalStyle from "@styles/style.module.css";
import utilStyle from "@styles/utils.module.css";
import {Link} from "react-router-dom";

const Index = () => {

    return (
        <div className={`${globalStyle.canvas} ${style.canvas_index}`}>
            <header>
                <h1 className={utilStyle.d_none}>제목입니다.</h1>
                <div className={`${style.header_container} ${utilStyle.d_fl_jf}`}>
                    <h1 className={`${style.logo_main} ${style.logo_etirovaf} ${utilStyle.m_t_80}`}>etirovaf</h1>
                </div>
            </header>
            {/*  */}
            <main>
                {/* flex start */}
                <div className={style.main_container}>
                    <h1 className={utilStyle.d_none}>바디</h1>
                    <div className={style.index_txt_wrap}>
                        <h2 className={style.index_title}>내가 가장 좋아하는 것 찾기</h2>
                        <div className={style.index_text_form}>
                            <span className={style.index_text}>
                                수백, 수만가지의 직업과 관련된 체험을<br />
                                경험할 수 있는 공간입니다.<br />
                                지금부터 당신이 가장 좋아하는 것을 <br />
                                찾으러 가보겠습니다.<br />
                            </span>
                        </div>
                    </div>
                </div>
                {/* flex end */}

                {/* flex start */}
                <div className={style.link_container}>
                    <h1 className={utilStyle.d_none}>시작</h1>
                    {/*<div className={style.btn_start}>*/}
                    {/*    <Link to={"/login"} className={style.start_text}>START </Link>*/}
                    {/*</div>*/}
                    <div className={style.btn_start_form}>
                        <Link to={"/home"}>
                            <button className={style.btn_start}>START</button>
                        </Link>
                    </div>
                </div>
                {/* flex end */}
            </main>
        </div>
    );
}

export default Index;