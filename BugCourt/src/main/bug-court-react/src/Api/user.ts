import apiRequester from './AxiosInstance';

interface User {
  userId: string;
  userPw: string;
  userNm: string;
  userEmail: string;
}




  // signUp
export const signUp = async ({ userId, userPw, userNm, userEmail }: User) => {
    const result = await apiRequester.post("/login/registerProcess", {
        userId,
        userPw,
        userNm,
        userEmail,
    });
  
    return result;
  };
  
  