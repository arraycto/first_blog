import request from '../utils/request'

export const listMenu= () =>{
  return request({
    url: '/menu/list',
    method: 'get',
  })
}
