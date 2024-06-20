import {useMutation, useQueryClient} from "@tanstack/react-query";
import {useNavigate} from "react-router-dom";
import {dream} from "@apis/dream.ts";
import {DreamValueType} from "@myTypes/dream/internal.ts";
import QUERY_KEYS from "@constants/@queryKeys/queryKeys.ts";

export const useCreateDream = () => {
    const queryClient = useQueryClient();
    const navigate = useNavigate();

    const { mutate } = useMutation(
        (dreamValueType: DreamValueType) => dream(dreamValueType),
        {
            async onSuccess() {
                await queryClient.refetchQueries([QUERY_KEYS.dream.list]);
                navigate('/home');
            },
        }
    );

    return {
        createDream: mutate,
    }
}