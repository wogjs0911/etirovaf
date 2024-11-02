export type DreamItemType = {
    dreamId?: null | number;
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


export type DreamValueType = {
    organizer: string;
    title: string;
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
