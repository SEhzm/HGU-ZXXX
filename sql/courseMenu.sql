-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course', '0', '1', 'course', 'course/course/index', 1, 0, 'C', '0', '0', 'course:course:list', '#', 'admin', sysdate(), '', null, 'course菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'course:course:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'course:course:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'course:course:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'course:course:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'course:course:export',       '#', 'admin', sysdate(), '', null, '');