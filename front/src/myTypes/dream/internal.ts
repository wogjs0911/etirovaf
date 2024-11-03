export type DreamItemDataType = {
    data: DreamItemType[];
};

export type DreamItemType = {
    id?: null | number;
    organizer?: string;
    title?: string;
    place?: string;
    hashTag?: string;
    deadline?: string;
    content?: string;
    createDate?: number;
};

export type PatternType = {
    rule: RegExp;
    message: string;
};

export type DreamInfoResponse = {
    data: DreamValueType;
};

export type DreamValueType = {
    organizer: string;
    title: string;
    numPeople: number;
    place: string;
    hashTag?: { name: string }[];
    deadline: string;
    content?: string;
    createDate?: number;

    // categoryId: null | number;
};

export type DreamItemDetailType = {
    organizer: string;
    title: string;
    place: string;
    hashTag?: { name: string }[];
    deadline: string;
    content?: string;
    createDate?: number;

    // categoryId: null | number;
};
