import client from "@apis/axios/client.ts";
import {DreamInfoResponse, DreamValueType} from "@myTypes/dream/internal.ts";
import {FILTER_COND} from "@constants/dream/dreamFilter.ts";
import {DreamItemResponse, DreamListRequest} from "@myTypes/dream/remote.ts";

export const dream = (body: DreamValueType) => {
    return client.post<DreamValueType>('/dream/reg', body);
};


export const getDreamList = async ({
      // id,
      filterCond = FILTER_COND.latest,
      size = 8,
      lastCreatedAt = '',
      lastId
    }: DreamListRequest): Promise<DreamItemResponse> => {
    const { data } = await client.get<DreamItemResponse>(
        '/dream/list',
        {
            params: {
                ...(lastId && { lastId }),
                filterCond,
                lastCreatedAt,
                size,
            },
        }
    );

    return data;
};


export const getDreamDetail = async (
    dreamId: number
): Promise<DreamInfoResponse> => {
    const { data } = await client.get<DreamInfoResponse>(
        `/dream/${dreamId}`,
    );
    return data;
};