package co.edu.uniquindio.estructurasDatos.ProyectoFinal.persistencia;

public class Persistencia {

	public static final String RUTA_ARCHIVO_VENDEDORES = "C:/td/persistencia/archivos/vendedores.txt";
	public static final String RUTA_ARCHIVO_USUARIOS   = "C:/td/persistencia/archivos/archivoUsuarios.txt";
	public static final String RUTA_ARCHIVO_PRODUCTOS  = "C:/td/persistencia/archivos/productos.txt";
	public static final String RUTA_ARCHIVO_TRANSACCION  = "C:/td/persistencia/archivos/producto_Transaccion.txt";
	public static final String RUTA_ARCHIVO_LOG = "C:/td/persistencia/log/marketPlace_Log.txt";
	public static final String RUTA_ARCHIVO_MODELO_MARKETONLY_XML = "C:/td/persistencia/model.xml";
	public static final String RUTA_ARCHIVO_MODELO_MARKETPLACE_BINARIO = "C:/td/persistencia/model.dat";
}

//	public static void cargarDatosArchivos(Marketplace marketOnly) throws FileNotFoundException, IOException {
//
//
//		//cargar archivo de usuarios
//		ArrayList<Usuario> usuariosCargados = cargarUsuarios();
//
//		if(usuariosCargados.size() > 0){
//			marketOnly.getListaUsuarios().addAll(usuariosCargados);
//		}
//
//		//cargar archivos Vendedores
//		ArrayList<Vendedor> vendedoresCargados = cargarVendedores();
//
//		if(vendedoresCargados.size() > 0){
//			marketOnly.getListaVendedor().addAll(vendedoresCargados);
//		}
//		//cargar archivo objetos
//
//		//cargar archivo empleados
//
//		//cargar archivo prestamo
//
//	}
//
//	/**
//	 * Guarda en un archivo de texto todos la informaci�n de los usuarios almacenadas en el ArrayList
//	 * @param objetos
//	 * @param ruta
//	 * @throws IOException
//	 */
//	public static void guardarUsuarios(ArrayList<Usuario> listaUsuarios) throws IOException {
//
//		String contenido = "";
//
//		for(Usuario usuario:listaUsuarios)
//		{
//			contenido+= usuario.getNombreUsuario()+"@@"+usuario.getNumCedula()+"@@"+usuario.getContraseña()+"@@"+usuario.getRolUsuario().toString()+"\n";
//		}
//		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIOS, contenido, false);
//
//	}
//
//
//	public static void guardarVendedores(ArrayList<Vendedor> listaVendedores) throws IOException {
//
//		String contenido = "";
//
//		for(Vendedor vendedor:listaVendedores)
//		{
//			contenido+= vendedor.getNombre()+"@@"+vendedor.getApellido()+"@@"+vendedor.getCedula()+"@@"+vendedor.getDireccion()+"\n";
//		}
//		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_VENDEDORES , contenido, false);
//	}
//
//	public static void guardarProductos(ArrayList<Vendedor> listaVendedores) throws IOException {
//
//		String contenido = "";
//
//		for (Vendedor vendedor : listaVendedores) {
//			for(Producto producto:vendedor.getListaProductos())
//			{
//				contenido+= producto.getNombre()+"@@"+producto.getCodigo()+"@@"+producto.getPrecio()+"@@"+producto.getCategoria().toString()+"@@"+producto.getEstado().toString()+"@@"+producto.getRutaImagenProducto()+"\n";
//			}
//		}
//
//		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PRODUCTOS,contenido, false);
//
//		guardarProductosTransaccion(listaVendedores);
//	}
//
//	public static void guardarProductosTransaccion(ArrayList<Vendedor> listaVendedores) throws IOException {
//
//		String contenido = "";
//
//		for (Vendedor vendedor : listaVendedores) {
//			for(Producto producto:vendedor.getListaProductos())
//			{
//				contenido+= producto.getUsuarioProducto().getNumCedula()+"@@"+producto.getNombre()+"@@"+producto.getCodigo()+"@@"+producto.getPrecio()+"@@"+producto.getCategoria().toString()+"@@"+producto.getEstado().toString()+"@@"+producto.getRutaImagenProducto()+"\n";
//			}
//		}
//
//		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_TRANSACCION, contenido, false);
//	}
//
//
////	----------------------LOADS------------------------
//
//	/**
//	 *
//	 * @param tipoPersona
//	 * @param ruta
//	 * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
//	 * @throws FileNotFoundException
//	 * @throws IOException
//	 */
//	public static ArrayList<Usuario> cargarUsuarios() throws FileNotFoundException, IOException
//	{
//		ArrayList<Usuario> usuarios =new ArrayList<Usuario>();
//
//		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_USUARIOS);
//		String linea="";
//
//		for (int i = 0; i < contenido.size(); i++)
//		{
//
//			linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
//			Usuario usuario = new Usuario();
//			usuario.setNombreUsuario(linea.split("@@")[0]);
//			usuario.setNumCedula(Integer.parseInt(linea.split("@@")[1]));
//			usuario.setContraseña(linea.split("@@")[2]);
//			usuario.setRolUsuario(obtenerRolUsuario(linea.split("@@")[3]));
//			usuarios.add(usuario);
//
//		}
//
//		return usuarios;
//	}
//
//
//	private static ArrayList<Vendedor> cargarVendedores() throws FileNotFoundException, IOException {
//
//		ArrayList<Vendedor> vendedores =new ArrayList<Vendedor>();
//
//		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_VENDEDORES);
//		String linea="";
//
//		for (int i = 0; i < contenido.size(); i++)
//		{
//			linea = contenido.get(i);
//			Vendedor vendedor = new Vendedor();
//			vendedor.setNombre(linea.split("@@")[0]);
//			vendedor.setApellido(linea.split("@@")[1]);
//			vendedor.setCedula(linea.split("@@")[2]);
//			vendedor.setDireccion(linea.split("@@")[3]);
//			vendedores.add(vendedor);
//		}
//		return vendedores;
//
//
//	}
//
//
//
//
//	public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
//	{
//
//		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
//	}
//
//
//	public static boolean iniciarSesion(String usuario, String contrasenia) throws FileNotFoundException, IOException, UsuarioNoExiste {
//
//		if(validarUsuario(usuario,contrasenia)) {
//			return true;
//		}else {
//			throw new UsuarioNoExiste("Usuario no existe");
//		}
//
//	}
//
//	private static boolean validarUsuario(String usuario, String contrasenia) throws FileNotFoundException, IOException
//	{
//		ArrayList<Usuario> usuarios = Persistencia.cargarUsuarios(RUTA_ARCHIVO_USUARIOS);
//
//		for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++)
//		{
//			Usuario usuarioAux = usuarios.get(indiceUsuario);
//			if(usuarioAux.getNombreUsuario().equalsIgnoreCase(usuario) && usuarioAux.getContraseña().equalsIgnoreCase(contrasenia)) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public static ArrayList<Usuario> cargarUsuarios(String ruta) throws FileNotFoundException, IOException {
//		ArrayList<Usuario> usuarios =new ArrayList<Usuario>();
//
//		ArrayList<String> contenido = ArchivoUtil.leerArchivo(ruta);
//		String linea="";
//
//		for (int i = 0; i < contenido.size(); i++) {
//			linea = contenido.get(i);
//
//			Usuario usuario = new Usuario();
//			usuario.setNombreUsuario(linea.split("@@")[0]);
//			usuario.setContraseña(linea.split("@@")[1]);
//
//			usuarios.add(usuario);
//		}
//		return usuarios;
//	}
//
//
////	----------------------SAVES------------------------
//
//	/**
//	 * Guarda en un archivo de texto todos la informaci�n de las personas almacenadas en el ArrayList
//	 * @param objetos
//	 * @param ruta
//	 * @throws IOException
//	 */
//
//	public static void guardarObjetos(ArrayList<Usuario> listaUsuarios, String ruta) throws IOException  {
//		String contenido = "";
//
//		for(Usuario usuarioAux:listaUsuarios) {
//			contenido+= usuarioAux.getNombreUsuario()+"@@"+usuarioAux.getNumCedula()+"@@"+usuarioAux.getContraseña()+"@@"+usuarioAux.getRolUsuario().toString()+"\n";
//
//		}
//		ArchivoUtil.guardarArchivo(ruta, contenido, true);
//	}
//
//
//
//
//
//	//------------------------------------SERIALIZACION  y XML
//
//
//	public static Marketplace cargarRecursoMarketplaceoBinario() {
//
//		Marketplace marketOnly = null;
//
//		try {
//			marketOnly = (Marketplace)ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_MARKETPLACE_BINARIO);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return marketOnly;
//	}
//
//	public static void guardarRecursoMarketplaceBinario(Marketplace marketOnly) {
//
//		try {
//			ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_MARKETPLACE_BINARIO, marketOnly);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//
//	public static Marketplace cargarRecursoMarketplaceXML() {
//
//		Marketplace marketOnly = null;
//
//		try {
//			marketOnly = (Marketplace)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_MARKETONLY_XML);
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//		return marketOnly;
//
//	}
//
//
//
//	public static void guardarRecursoMarketplaceXML(Marketplace marketOnly) {
//
//		try {
//			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_MARKETONLY_XML, marketOnly);
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//	}
//
//
//	static RolUsuario obtenerRolUsuario(String rolUsuario) {
//
//		if(rolUsuario.equals("Administrador")){
//
//			return RolUsuario.ADMINISTRADOR;
//
//		}else{
//
//			return RolUsuario.VENDEDOR;
//
//		}
//	}
//
//	public static void crearRespaldo() {
//
//		try {
//
//			String ruta = RUTA_ARCHIVO_MODELO_MARKETONLY_XML;
//
//			Path fuente = Paths.get(ruta);
//			Path destino = Paths.get("C:/td/persistencia/respaldo/model_"+ArchivoUtil.fechaSistema+"-"+ArchivoUtil.obtenerHora()+".xml");
//
//			Files.copy(fuente, destino, StandardCopyOption.REPLACE_EXISTING);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//	}
//
//
//}
