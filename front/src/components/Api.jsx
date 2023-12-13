import {useState, useEffect} from "react";
import axios from "axios";

const Api = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        const res = () => axios.get('http://localhost:8080/test')
            .then((Response) => {
                setData(Response.data)
                console.log(Response.data);
            })
            .catch((Error) => {
                console.log(Error)
            })
            res()
    }, []);

    return data.length > 0 ?
    (
        <div>
            {
                data.map((key,idx) =>(
                    <p key={idx}>
                        {key.id} / {key.username}
                    </p>
                ))
            }
        </div>
    ) : <div></div>;
}

export default Api