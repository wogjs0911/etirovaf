export type DreamItemType = {
    id: number;
    organizer: string;
    title: string;
    place: string;
    hashTag: string;
    deadline: string;
    content?: string;
    createDate?: number;
};

export type PatternType = {
    rule: RegExp;
    message: string;
};