/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.32
 * Generated at: 2019-05-10 20:51:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.tag.web.responsive.cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ajaxCartPromotions_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/usr/local/opt/sap_commerce/CXCOMM181100P_5-70004085/hybris/bin/platform/ext/core/lib/spring-webmvc-4.3.21.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1543325266000L));
    _jspx_dependants.put("file:/usr/local/opt/sap_commerce/CXCOMM181100P_5-70004085/hybris/bin/platform/ext/core/lib/spring-webmvc-4.3.21.RELEASE.jar", Long.valueOf(1554133035000L));
    _jspx_dependants.put("/WEB-INF/common/tld/ycommercetags.tld", Long.valueOf(1557519559000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private javax.servlet.jsp.JspContext jspContext;
  private java.io.Writer _jspx_sout;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fhtmlEscape_0026_005fdefaultHtmlEscape_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005ftheme_0026_005fcode_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public void setJspContext(javax.servlet.jsp.JspContext ctx) {
    super.setJspContext(ctx);
    java.util.ArrayList _jspx_nested = null;
    java.util.ArrayList _jspx_at_begin = null;
    java.util.ArrayList _jspx_at_end = null;
    this.jspContext = new org.apache.jasper.runtime.JspContextWrapper(this, ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
  }

  public javax.servlet.jsp.JspContext getJspContext() {
    return this.jspContext;
  }

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    return _jsp_instancemanager;
  }

  private void _jspInit(javax.servlet.ServletConfig config) {
    _005fjspx_005ftagPool_005fspring_005fhtmlEscape_0026_005fdefaultHtmlEscape_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(config);
    _005fjspx_005ftagPool_005fspring_005ftheme_0026_005fcode_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(config);
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(config.getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(config);
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fspring_005fhtmlEscape_0026_005fdefaultHtmlEscape_005fnobody.release();
    _005fjspx_005ftagPool_005fspring_005ftheme_0026_005fcode_005fnobody.release();
  }

  public void doTag() throws javax.servlet.jsp.JspException, java.io.IOException {
    javax.servlet.jsp.PageContext _jspx_page_context = (javax.servlet.jsp.PageContext)jspContext;
    javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest) _jspx_page_context.getRequest();
    javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse) _jspx_page_context.getResponse();
    javax.servlet.http.HttpSession session = _jspx_page_context.getSession();
    javax.servlet.ServletContext application = _jspx_page_context.getServletContext();
    javax.servlet.ServletConfig config = _jspx_page_context.getServletConfig();
    javax.servlet.jsp.JspWriter out = jspContext.getOut();
    _jspInit(config);
    jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,jspContext);

    try {
      if (_jspx_meth_spring_005fhtmlEscape_005f0(_jspx_page_context))
        return;
      out.write("<script id=\"cartPromotionSectionTemplate\" type=\"text/x-jquery-tmpl\">\n");
      out.write("    {{if appliedOrderPromotions.length > 0}}\n");
      out.write("        <div class=\"cartproline\">\n");
      out.write("             ");
      if (_jspx_meth_spring_005ftheme_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_ycommerce_005ftestId_005f0(_jspx_page_context))
        return;
      out.write("</div>\n");
      out.write("    {{/if}}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<div id=\"ajaxCartPromotionSection\">\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
    } catch( java.lang.Throwable t ) {
      if( t instanceof javax.servlet.jsp.SkipPageException )
          throw (javax.servlet.jsp.SkipPageException) t;
      if( t instanceof java.io.IOException )
          throw (java.io.IOException) t;
      if( t instanceof java.lang.IllegalStateException )
          throw (java.lang.IllegalStateException) t;
      if( t instanceof javax.servlet.jsp.JspException )
          throw (javax.servlet.jsp.JspException) t;
      throw new javax.servlet.jsp.JspException(t);
    } finally {
      jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,super.getJspContext());
      ((org.apache.jasper.runtime.JspContextWrapper) jspContext).syncEndTagFile();
      _jspDestroy();
    }
  }

  private boolean _jspx_meth_spring_005fhtmlEscape_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:htmlEscape
    org.springframework.web.servlet.tags.HtmlEscapeTag _jspx_th_spring_005fhtmlEscape_005f0 = (org.springframework.web.servlet.tags.HtmlEscapeTag) _005fjspx_005ftagPool_005fspring_005fhtmlEscape_0026_005fdefaultHtmlEscape_005fnobody.get(org.springframework.web.servlet.tags.HtmlEscapeTag.class);
    boolean _jspx_th_spring_005fhtmlEscape_005f0_reused = false;
    try {
      _jspx_th_spring_005fhtmlEscape_005f0.setPageContext(_jspx_page_context);
      _jspx_th_spring_005fhtmlEscape_005f0.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));      // /WEB-INF/tags/responsive/cart/ajaxCartPromotions.tag(5,0) name = defaultHtmlEscape type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_spring_005fhtmlEscape_005f0.setDefaultHtmlEscape(true);
      int[] _jspx_push_body_count_spring_005fhtmlEscape_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_spring_005fhtmlEscape_005f0 = _jspx_th_spring_005fhtmlEscape_005f0.doStartTag();
        if (_jspx_th_spring_005fhtmlEscape_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          throw new javax.servlet.jsp.SkipPageException();
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_005fhtmlEscape_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_005fhtmlEscape_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_005fhtmlEscape_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fspring_005fhtmlEscape_0026_005fdefaultHtmlEscape_005fnobody.reuse(_jspx_th_spring_005fhtmlEscape_005f0);
      _jspx_th_spring_005fhtmlEscape_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_spring_005fhtmlEscape_005f0, _jsp_getInstanceManager(), _jspx_th_spring_005fhtmlEscape_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005ftheme_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:theme
    org.springframework.web.servlet.tags.ThemeTag _jspx_th_spring_005ftheme_005f0 = (org.springframework.web.servlet.tags.ThemeTag) _005fjspx_005ftagPool_005fspring_005ftheme_0026_005fcode_005fnobody.get(org.springframework.web.servlet.tags.ThemeTag.class);
    boolean _jspx_th_spring_005ftheme_005f0_reused = false;
    try {
      _jspx_th_spring_005ftheme_005f0.setPageContext(_jspx_page_context);
      _jspx_th_spring_005ftheme_005f0.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));      // /WEB-INF/tags/responsive/cart/ajaxCartPromotions.tag(10,13) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_spring_005ftheme_005f0.setCode("basket.received.promotions");
      int[] _jspx_push_body_count_spring_005ftheme_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_spring_005ftheme_005f0 = _jspx_th_spring_005ftheme_005f0.doStartTag();
        if (_jspx_th_spring_005ftheme_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          throw new javax.servlet.jsp.SkipPageException();
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_005ftheme_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_005ftheme_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_005ftheme_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fspring_005ftheme_0026_005fcode_005fnobody.reuse(_jspx_th_spring_005ftheme_005f0);
      _jspx_th_spring_005ftheme_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_spring_005ftheme_005f0, _jsp_getInstanceManager(), _jspx_th_spring_005ftheme_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_ycommerce_005ftestId_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  ycommerce:testId
    de.hybris.platform.yb2bacceleratorstorefront.tags.TestIdTag _jspx_th_ycommerce_005ftestId_005f0 = new de.hybris.platform.yb2bacceleratorstorefront.tags.TestIdTag();
    _jsp_getInstanceManager().newInstance(_jspx_th_ycommerce_005ftestId_005f0);
    try {
      _jspx_th_ycommerce_005ftestId_005f0.setJspContext(_jspx_page_context);
      _jspx_th_ycommerce_005ftestId_005f0.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));      // /WEB-INF/tags/responsive/cart/ajaxCartPromotions.tag(11,13) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ycommerce_005ftestId_005f0.setCode("cart_recievedPromotions_labels");
      _jspx_th_ycommerce_005ftestId_005f0.setJspBody(new Helper( 0, _jspx_page_context, _jspx_th_ycommerce_005ftestId_005f0, null));
      _jspx_th_ycommerce_005ftestId_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_ycommerce_005ftestId_005f0);
    }
    return false;
  }

  private class Helper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public Helper( int discriminator, javax.servlet.jsp.JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      out.write("\n");
      out.write("             {{each(index, appliedOrderPromotion) appliedOrderPromotions}}\n");
      out.write("                 <div class=\"promotion\">{{= appliedOrderPromotion.description}}</div>\n");
      out.write("             {{/each}}\n");
      out.write("             ");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws javax.servlet.jsp.JspException
    {
      javax.servlet.jsp.JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        Object _jspx_saved_JspContext = this.jspContext.getELContext().getContext(javax.servlet.jsp.JspContext.class);
        this.jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,this.jspContext);
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
        }
        jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,_jspx_saved_JspContext);
      }
      catch( java.lang.Throwable e ) {
        if (e instanceof javax.servlet.jsp.SkipPageException)
            throw (javax.servlet.jsp.SkipPageException) e;
        throw new javax.servlet.jsp.JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}
