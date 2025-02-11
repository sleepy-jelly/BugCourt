// Email: (alphabet/numeric) + @ + (alphabet) + (.com)
export const validateEmail = (email: string) => {
    return /([\d\w])+@{1}([a-z])+(.com$)/.test(email);
  };
  
  export const validateNickname = (nickname: string) => {
    return /^[a-z\d\w]{2,8}$/.test(nickname);
  };
  
  export const validatePassword = (value: string) => {
    return value.length >= 4 && value.length <= 10;
  };