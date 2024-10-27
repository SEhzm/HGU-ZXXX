-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course_enrollments', '0', '1', 'enrollments', 'course/enrollments/index', 1, 0, 'C', '0', '0', 'course:enrollments:list', '#', 'admin', sysdate(), '', null, 'course_enrollments菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course_enrollments查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'course:enrollments:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course_enrollments新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'course:enrollments:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course_enrollments修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'course:enrollments:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course_enrollments删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'course:enrollments:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('course_enrollments导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'course:enrollments:export',       '#', 'admin', sysdate(), '', null, '');