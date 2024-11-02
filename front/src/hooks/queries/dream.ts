// import {useMutation, useQueryClient} from "@tanstack/react-query";
import {useInfiniteQuery, useMutation} from "@tanstack/react-query";
import {useNavigate} from "react-router-dom";
import {dream, getDreamList} from "@apis/dream.ts";
import {DreamValueType} from "@myTypes/dream/internal.ts";
import QUERY_KEYS from "@constants/@queryKeys/queryKeys.ts";
import {DreamListRequest} from "@myTypes/dream/remote.ts";
// import QUERY_KEYS from "@constants/@queryKeys/queryKeys.ts";

export const useCreateDream = () => {
    // const queryClient = useQueryClient();
    const navigate = useNavigate();

    const { mutate } = useMutation(
        (dreamValueType: DreamValueType) => dream(dreamValueType),
        {
            // async onSuccess() {
            onSuccess() {
                // await queryClient.refetchQueries([QUERY_KEYS.dream.list]);
                navigate('/home');
            },
        }
    );

    return {
        createDream: mutate,
    }
}


export const useDreamList = (params : DreamListRequest) => {
    // const { dreamId } = params;

    const { data, fetchNextPage } = useInfiniteQuery(
        [QUERY_KEYS.dream.list],
        ({ pageParam }) => getDreamList({ ...params, lastId: pageParam }),
        {
            getNextPageParam: (lastPage) =>
                lastPage.hasNext
                    ? lastPage.responses[lastPage.responses.length - 1]?.dreamId
                    : undefined,
        }
    );

    const responses = data?.pages.flatMap((page) => page.responses) || [];

    const hasNext = Boolean(data?.pages[data.pages.length - 1]?.hasNext);

    return { dreamListResponse: { responses, hasNext }, fetchNextPage };
};