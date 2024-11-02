import {DreamItemType} from "@myTypes/dream/internal.ts";
import {FILTER_COND} from "@constants/dream/dreamFilter.ts";


type FilterCondType = (typeof FILTER_COND)[keyof typeof FILTER_COND];

export type DreamListRequest = {
    // dreamId: number;
    lastCreatedAt?: any;
    size?: number;
    filterCond?: FilterCondType;
    lastId?: number | null;
};

export type DreamItemResponse = {
    responses: DreamItemType[];
    hasNext: boolean;
};