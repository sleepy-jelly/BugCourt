import AxiosInstance from 'axios';

interface User {
  email: string;
  nickName: string;
  password: string;
}

// 회원가입
export const register = async ({ email, nickName, password }: User) => {
  const result = await AxiosInstance.post("/users/register", {
    email,
    nickName,
    password,
  });

  return result;
};