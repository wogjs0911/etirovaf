import axios from "axios";

export async function fetchDreams() {
    try {
        const response = await axios.get(
            "http://localhost:8080/test"
        );
        console.log(response.data);
        return response.data;
    } catch (e) {
        return [];
    }
}