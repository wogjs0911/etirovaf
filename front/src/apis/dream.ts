import client from "@apis/axios/client.ts";
import {DreamValueType} from "@myTypes/dream/internal.ts";

export const dream = (body: DreamValueType) => {
    return client.post('/api/dream/reg', body);
};