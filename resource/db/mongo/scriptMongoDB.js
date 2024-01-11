use admin;
db.createUser(
{
	user: "usaurio_owner",
	pwd: "usuario_password",
	roles: [{role: "userAdmin", db: "usuariodb"}]
})
