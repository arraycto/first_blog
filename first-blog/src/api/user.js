import request from '../utils/request'

export const Registers= (userName,userPass,userNickname,userEmail) =>{
  return request({
    url: '/user/insert',
    method: 'post',
    params:{
      userName,
      userPass,
      userNickname,
      userEmail
    }
  }).then(err=>{
    console.log(err)
  })
}

export const findGetUserName= (UserName) =>{
  return request({
    url: '/user/getUserName',
    method: 'get',
    params:{
      UserName
    }
  })
}

export const loginSubmit= (UserName,userPass) =>{
  return request({
    url: '/user/loginSubmit',
    method: 'post',
    params: {
      UserName,
      userPass
    }
  })
}



