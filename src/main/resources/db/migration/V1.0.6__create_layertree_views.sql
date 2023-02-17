create view filtered_servers(user_email, id, ogcprotocol, title, version, url, queryable) as
SELECT DISTINCT users.email AS user_email,
                s.id,
                s.ogcprotocol,
                s.title,
                s.version,
                s.url,
                s.queryable
FROM users
         JOIN bindings b ON b.fk_users_id = users.id
         JOIN role r ON r.id = b.fk_role_id
         JOIN acl ON acl.fk_role_id = r.id
         JOIN layer l ON l.id = acl.fk_layer_id
         JOIN server s ON s.id = l.fk_server_id;


create view merged_layer_acl (user_email, user_id, id, fk_server_id, name, title, matrixset, queriable) as
SELECT users.email AS user_email,
       users.id    AS user_id,
       l.id,
       l.fk_server_id,
       l.name,
       l.title,
       l.matrixset,
       l.queriable
FROM users
         JOIN bindings b ON b.fk_users_id = users.id
         JOIN role r ON r.id = b.fk_role_id
         JOIN acl ON acl.fk_role_id = r.id
         JOIN layer l ON l.id = acl.fk_layer_id
         JOIN server s ON s.id = l.fk_server_id;



