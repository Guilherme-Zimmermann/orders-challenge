import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios, { AxiosPromise } from "axios";
import { MenuData } from "../interface/MenuData";

const API_URL = 'http://localhost:8080';

const postData = async (data: MenuData): AxiosPromise<any> => {
    const response = axios.post(API_URL + '/products', data);
    return response;
}

export function useMenuDataMutate(){
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData,
        retry: 2,
        onSuccess: () => {
            queryClient.invalidateQueries(['menu-data'])
        }
    })

    return mutate;
}