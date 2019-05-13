# yCommerceLibrary.podspec
# [y] hybris Platform
#
# Copyright (c) 2000-2015 hybris AG
# All rights reserved.
#
# This software is the confidential and proprietary information of hybris
# ("Confidential Information"). You shall not disclose such Confidential
# Information and shall use it only in accordance with the terms of the
# license agreement you entered into with hybris.
#

#
# Be sure to run `pod lib lint yCommerceLibrary.podspec' to ensure this is a
# valid spec and remove all comments before submitting the spec.
#
# Any lines starting with a # are optional, but encouraged
#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html
#

Pod::Spec.new do |s|
  s.name             = "yCommerceLibrary"
  s.version          = "1808"
  s.summary          = "Hybris Mobile [y] Commerce Library that contains all SDK functionality for mobile commerce apps."
  s.description      = <<-DESC
                        Hybris Mobile [y] Commerce Library with all domain specific libraries that can be used to build mobile commerce apps.
                        You should reference this pod from your app and use the domain specific library interface (e.g. b2b) in your controllers.
                       DESC
  s.homepage         = "https://wiki.hybris.com/display/b2b/IOS+Architecture+-+5.5"
  s.license          = 'Commercial'
  s.author           = { "Playmobile IOS Team Hybris" => "yann.bouschet@hybris.com" }
  s.source           = { :git => "https://stash.hybris.com/projects/MOBILE/repos/b2bios/browse/yCommerceLibrary", :tag => s.version.to_s }
  s.platform     = :ios, '7.1'
  s.requires_arc = true
  s.source_files = 'Pod/Classes/**/*.{h,m}'
  s.resource_bundles = {
    'yCommerceLibrary' => ['Pod/Assets/*.png']
  }
  s.dependency 'Mantle', '~>1.5.4'
  s.dependency 'CocoaLumberjack', '1.8.1'
  s.dependency 'AFNetworking', '2.5.1'
  s.dependency 'MyEnvironmentConfig'
  s.dependency 'libextobjc', '0.4.1'
  s.dependency 'PromiseKit', '~>1.7.6'
  s.dependency 'PromiseKit-AFNetworking', '0.1.6'
  s.dependency 'OMGHTTPURLRQ', '3.2'
  
end
